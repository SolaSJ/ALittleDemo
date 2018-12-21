package com.sola.alittledemo.util.workovertime;

import lombok.*;

/**
 * 加班时间和津贴实体类
 *
 * @author caijun
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class WorkOvertimeEntity {
    private String startTime; // 加班开始时间
    private String endTime; // 加班结束时间
    private Double mealSubsidy; // 餐补
    private Double extSubsidy; // 其他津贴（交通）
}
