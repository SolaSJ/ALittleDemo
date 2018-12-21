package com.sola.alittledemo.util.workovertime;

import java.text.DecimalFormat;
import java.time.Duration;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

/**
 * 计算加班时长以及补贴
 * @author caijun
 *
 */
public class CalcWorkOvertimeAndSubsidy {

	@SuppressWarnings("all")
	public static void main(String[] args) {
		// 11月加班
		List<WorkOvertimeEntity> list11 = new ArrayList<>();
        WorkOvertimeEntity work1 = new WorkOvertimeEntity("17:32:00", "01:00:00", 35d, null);
		WorkOvertimeEntity work2 = new WorkOvertimeEntity("09:00:00", "17:00:00", 70d, null); // 11-3周末
		WorkOvertimeEntity work3 = new WorkOvertimeEntity("17:36:00", "23:24:00", 35d, null); // 11-6
		WorkOvertimeEntity work4 = new WorkOvertimeEntity("09:00:00", "17:00:00", 70d, null); // 11-10周末
		WorkOvertimeEntity work5 = new WorkOvertimeEntity("17:46:00", "23:37:00", 35d, null); // 11-13
		WorkOvertimeEntity work6 = new WorkOvertimeEntity("17:53:00", "21:16:00", 35d, null); // 11-23升级

		// WorkOvertimeEntity build = WorkOvertimeEntity.builder().endTime().extSubsidy().build();
		list11.add(work1);
		list11.add(work2);
		list11.add(work3);
		list11.add(work4);
		list11.add(work5);
		list11.add(work6);
		
		// 蔡俊11月加班
		calcTotalTimeAndSubsidy("蔡俊", "11月", list11);
		
	}
	
	// 计算总调休时间和津贴
	public static void calcTotalTimeAndSubsidy(String name, String month, List<WorkOvertimeEntity> list) {
		double TotalTime = 0.0;
		double TotalSubsidy = 0.0;
		for (WorkOvertimeEntity w : list) {
			boolean flag = false;
			if (w.getEndTime().compareTo(w.getStartTime()) < 0) {
				String start = w.getStartTime();
				String end = w.getEndTime();
				w.setStartTime(end);
				w.setEndTime(start);
				flag = true;
			}
			LocalTime localTime1 = LocalTime.parse(w.getStartTime());
			LocalTime localTime2 = LocalTime.parse(w.getEndTime());
			if (flag) {
				TotalTime += (1440 - (Duration.between(localTime1, localTime2).toMinutes()));
			} else {
				TotalTime += (Duration.between(localTime1, localTime2).toMinutes());
			}
			TotalSubsidy += w.getMealSubsidy() != null ? w.getMealSubsidy() : 0;
			TotalSubsidy += w.getExtSubsidy() != null ? w.getExtSubsidy() : 0;
		}
		DecimalFormat df = new DecimalFormat("#.00");
		System.out.println(name + "这个大帅比" + month + "加班统计==>\n" + "本月加班天数：" + list.size() + "天");
		System.out.print("本月加班时间：" + df.format(TotalTime / 60 / 8) + "天\n" + "本月加班津贴：" + TotalSubsidy + "元");
	}
	
}


