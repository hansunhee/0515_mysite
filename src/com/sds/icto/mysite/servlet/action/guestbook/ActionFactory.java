package com.sds.icto.mysite.servlet.action.guestbook;

import com.sds.icto.mysite.servlet.action.main.IndexAction;
import com.sds.icto.web.Action;

public class ActionFactory {
	private static ActionFactory instance;
	static{
		instance=new ActionFactory();
	}
	
	private ActionFactory(){
		
	}
	public static ActionFactory getInstance(){
		return instance;
	}
	public Action getAction(String a){
		Action action=null;
		if("list".equals(a)){
			action=new ListAction();
		}else if("insert".equals(a)){
			action=new InsertAction();			
		}else if("deleteform".equals(a)){
			action=new DeleteFormAction();			
		}else if("delete".equals(a)){
			action=new DeleteAction();			
		}
		if(action==null){
			action=new IndexAction();
		}
		return action;
	}
}