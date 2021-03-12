package org.comstudy21.myweb.board;

import lombok.Data;

@Data
public class BoardVO {
	private int seq;
	private String title;
	private String writer;
	private String content;
	private String regData;
	private int cnt;

}
