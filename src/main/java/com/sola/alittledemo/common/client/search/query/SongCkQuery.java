package com.sola.alittledemo.common.client.search.query;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

/**
 * @author Sola
 * @date 2018/11/30
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SongCkQuery {

    /**
     * 版权id
     */
    private String copyrightId;
    /**
     * 歌曲id
     */
    private List<Long> songIds;
    /**
     * 项目id
     */
    private Long pid;
    /**
     * 歌曲名
     */
    private String songName;
    /**
     * 艺人名
     */
    private String artistName;
    /**
     * 专辑名
     */
    private String albumName;
    /**
     * 抽查类型, 见CkType常量类定义
     */
    private String dataType;
    /**
     * 数据id
     */
    private String dataId;
    /**
     * 数据id字段拆分, 工单日期, 用于查询
     */
    private String taskDate;
    /**
     * 数据id字段拆分, 工单项目id, 用于查询
     */
    private String taskPid;
    /**
     * 数据id字段拆分, 工单流转来源编辑工单的编辑人id, 用于查询
     */
    private String taskUid;
    /**
     * 编辑者
     */
    private String editor;
    /**
     * 审核者
     */
    private String auditor;
    /**
     * 是否批量
     */
    private Integer ifBatch;
    /**
     * 抽查者
     */
    private Integer ckUid;
    /**
     * 抽查结果
     */
    private Integer ckResult;
    /**
     * 编辑时间起
     */
    private Timestamp editSt;
    /**
     * 编辑时间止
     */
    private Timestamp editEt;
    /**
     * 审核时间起
     */
    private Timestamp auditSt;
    /**
     * 审核时间止
     */
    private Timestamp auditEt;
    /**
     * 抽查时间起
     */
    private Timestamp checkSt;
    /**
     * 抽查时间止
     */
    private Timestamp checkEt;
    /**
     * 抽查错误分类
     */
    private List<Integer> ckTagErrors;
    /**
     * 项目工单, 来源编辑工单id
     */
    private List<Integer> pids;
    /**
     * 素材标识
     */
    private List<Long> markIds;
    /**
     * 导入查询sql
     */
    private String excelSql;
    /**
     * 是否为导入查询
     */
    private boolean excelQuery;
    /**
     * 是否count
     */
    private boolean queryCount;
    /**
     * 是否为导出
     */
    private boolean export;
    /**
     * 按选中导出, 根据taskIds查找
     */
    private List<Long> taskIds;
    /**
     * 排序字段
     */
    private Map<String, String> orderBys;
    /**
     * 排序字段
     */
    private String orderBySql;
    /**
     * 页面大小
     */
    private Integer pageSize;
    /**
     * 页码
     */
    private Integer pageNo;
    /**
     * 工单状态集合
     */
    private List<Integer> taskStatusList;
    /**
     * 是否抽查完成
     */
    private boolean isCompleteCheck;
    /**
     * 用于模糊查询
     */
    private String songNameLikeParam;
    /**
     * 用于模糊查询
     */
    private String albumNameLikeParam;
    /**
     * 用于模糊查询
     */
    private String artistNameLikeParam;
    /**
     * 歌曲评分小
     */
    private BigDecimal songScoreMin;
    /**
     * 歌曲评分大
     */
    private BigDecimal songScoreMax;
    /**
     * 专辑评分小
     */
    private BigDecimal albumScoreMin;
    /**
     * 专辑评分大
     */
    private BigDecimal albumScoreMax;
    /**
     * 艺人评分小
     */
    private BigDecimal artistScoreMin;
    /**
     * 艺人评分大
     */
    private BigDecimal artistScoreMax;
    /**
     * 来源编辑工单pid
     */
    private String editPid;
    /**
     * 标签
     */
    private List<Long> tags;
    /**
     * 是否关联专辑表
     */
    private boolean isRelateAlbum;
    /**
     * 是否关联艺人表
     */
    private boolean isRelateArtist;
    /**
     * 是否关联版权表
     */
    private boolean isRelateCopyright;
    /**
     * 导出功能的分页起始值
     */
    private Integer startNo;
    /**
     * 导出功能的分页结束值
     */
    private Integer endNo;

    /**
     * 获取起始行
     *
     * @return
     */
    public Integer getStartRow() {
        return pageNo == null || pageSize == null ? null : (pageNo - 1) * pageSize;
    }

}
