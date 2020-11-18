package com.tools;

import lombok.Data;

import java.util.List;

/**
 * @author Mr.Tong
 *	分页显示工具类
 * @param <T>	传入的泛型集合
 */
@Data
public class PageBean<T> {

	//当前页第几页，从请求那边传过来
	private int pageNum;

	//每页显示的数据条数
	private int pageSize;

	//总的记录条数
	private int totalRecord;

	//总页数
	private int totalPage;

	//limit开始索引
	private int startIndex;

	//分页显示的数据存放在list集合中

	private T object;

	private List<T> list;

	private int start;

	private int end;

	public PageBean(int pageNum, int pageSize, int totalRecord) {
		this.pageNum = pageNum;
		this.pageSize = pageSize;
		this.totalRecord = totalRecord;

		//计算总页数
		if(totalRecord%pageSize == 0) {
			this.totalPage = totalRecord / pageSize;
		}else {
			this.totalPage = totalRecord / pageSize + 1;
		}

		//开始索引
		this.startIndex = (pageNum-1) * pageSize;
		this.start = 1;
		this.end = 5;

		//显示页码的算法
		//显示5页
		if(totalPage <= 5) {
			this.end = this.totalPage;
		}else {
			this.start = pageNum - 2;
			this.end = pageNum + 2;
			System.out.println(start);
			if(start < 0) {
				this.start = 1;
				this.end = 5;
			}
			if(end > this.totalPage) {
				this.end = totalPage;
				this.start = end-5;
			}
		}
	}
}
