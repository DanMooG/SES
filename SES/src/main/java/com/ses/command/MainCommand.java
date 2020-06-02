package com.ses.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface MainCommand {
	void execute(HttpServletRequest requst, HttpServletResponse response);
}
