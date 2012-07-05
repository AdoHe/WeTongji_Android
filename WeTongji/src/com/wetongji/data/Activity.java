package com.wetongji.data;

import java.util.Date;

import com.j256.ormlite.field.DatabaseField;

public class Activity {
	
	@DatabaseField(id=true)
	int id;
	@DatabaseField
	Date begin;
	@DatabaseField
	Date end;
	@DatabaseField
	String title;
	@DatabaseField
	String location;
	@DatabaseField
	int favourite;			//�ղؼ�����
	@DatabaseField
	int like;				//+1������
	@DatabaseField
	int schedule;			//��ӵ��ճ̼�����
	@DatabaseField
	boolean canFavourite;	//�Ƿ�����ղ�
	@DatabaseField
	boolean canLike;		//�Ƿ����+1
	@DatabaseField
	boolean canSchedule;	//�Ƿ������ӵ��ճ�
	@DatabaseField
	int channel_id;
	@DatabaseField
	String organizer;
	@DatabaseField
	String status;
	@DatabaseField
	String description;
	
	
	
	/**
	 * 
	 */
	public Activity() {
	}



	/**
	 * @param id
	 * @param begin
	 * @param end
	 * @param title
	 * @param location
	 * @param favourite
	 * @param like
	 * @param schedule
	 * @param canFavourite
	 * @param canLike
	 * @param canSchedule
	 * @param channel_id
	 * @param organizer
	 * @param status
	 * @param description
	 */
	public Activity(int id, Date begin, Date end, String title, String location,
			int favourite, int like, int schedule, boolean canFavourite,
			boolean canLike, boolean canSchedule, int channel_id,
			String organizer, String status, String description) {
		this.id = id;
		this.begin = begin;
		this.end = end;
		this.title = title;
		this.location = location;
		this.favourite = favourite;
		this.like = like;
		this.schedule = schedule;
		this.canFavourite = canFavourite;
		this.canLike = canLike;
		this.canSchedule = canSchedule;
		this.channel_id = channel_id;
		this.organizer = organizer;
		this.status = status;
		this.description = description;
	}
	
}
