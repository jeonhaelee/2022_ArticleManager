package com.koreaIT.java.AM;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.koreaIT.java.AM.controller.ArticleController;
import com.koreaIT.java.AM.controller.Controller;
import com.koreaIT.java.AM.controller.MemberController;
import com.koreaIT.java.AM.dto.Article;
import com.koreaIT.java.AM.dto.Member;
import com.koreaIT.java.AM.util.Util;

public class App {

	public void start() {
		System.out.println("== 프로그램 시작 ==");

		Scanner sc = new Scanner(System.in);

		MemberController memberController = new MemberController(sc);
		ArticleController articleController = new ArticleController(sc);
		
		articleController.makeTestData();
		
		while (true) {
			System.out.printf("명령어) ");
			String command = sc.nextLine().trim();

			if (command.length() == 0) {
				continue;
			}

			if (command.equals("system exit")) {
				break;
			}

			String[] commandBits = command.split(" ");
			
			if (commandBits.length == 1) {
				System.out.println("존재하지 않는 명령어입니다.");
				continue;
			}
			
			String controllerName = commandBits[0];
			String actionMethodName = commandBits[1];
			
			Controller controller = null;
			
			if(controllerName.equals("article")) {
				controller = articleController;
			} else if (controllerName.equals("member")) {
				controller = memberController;
			} else {
				System.out.println("존재하지 않는 명령어입니다.");
				continue;
			}
			
			controller.doAction(command, actionMethodName);
			
//			if (command.equals("member join")) {
//				memberController.doJoin();
//			}
//			else if (command.equals("article write")) {
//				articleController.doWrite();
//			} else if (command.equals("article list")) {
//				articleController.showList(command);
//			} else if (command.startsWith("article detail ")) {
//				articleController.showDetail(command);
//			} else if (command.startsWith("article modify ")) {
//				articleController.doModify(command);
//			} else if (command.startsWith("article delete ")) {
//				articleController.doDelete(command);
//			} else {
//				System.out.printf("%s는(은) 존재하지 않는 명령어 입니다.\n", command);
//			}
			
		}
		sc.close();
		System.out.println("== 프로그램 끝 ==");
	}
	
}
