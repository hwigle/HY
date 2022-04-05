package com.work;

import java.util.List;

public interface ReplyService {
	
	public void insertReply(Reply reply);
	public void modifyReply(Reply reply);
	public void deleteReply(Reply reply);
	public List<Reply> replyList();
	public Reply getReply(String rwriter);

}
