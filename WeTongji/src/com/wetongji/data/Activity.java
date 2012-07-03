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
	Activity() {
	}
	
}
