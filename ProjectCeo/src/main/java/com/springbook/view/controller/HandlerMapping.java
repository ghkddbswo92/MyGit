package com.springbook.view.controller;

import java.util.HashMap;
import java.util.Map;

import com.springbook.view.admin.AdminController;
import com.springbook.view.admin.Menu.MenuController;
import com.springbook.view.admin.Menu.MenuDeleteController;
import com.springbook.view.admin.Menu.MenuInsertController;
import com.springbook.view.admin.Menu.MenuRecipeController;
import com.springbook.view.admin.Menu.MenuUpdateController;
import com.springbook.view.admin.recipe.RecipController;
import com.springbook.view.admin.recipe.RecipeDeleteController;
import com.springbook.view.admin.recipe.RecipeInsertController;
import com.springbook.view.admin.recipe.RecipeUpdateController;
import com.springbook.view.guest.GuestController;
import com.springbook.view.guest.GuestFinish;
import com.springbook.view.guest.GuestRSController;
import com.springbook.view.user.LoginController;
import com.springbook.view.user.LogoutController;
import com.springbook.view.user.SignInController;

public class HandlerMapping {
	private Map<String, Controller> mappings;
	
	public HandlerMapping() {
		// TODO Auto-generated constructor stub
		mappings = new HashMap<String, Controller>();
		mappings.put("/login.do", new LoginController());
		mappings.put("/logout.do", new LogoutController());
		mappings.put("/signIn.do", new SignInController());
		mappings.put("/guest.do", new GuestController());
		mappings.put("/Guest_Finish.do",new GuestFinish());
		mappings.put("/guestRS.do", new GuestRSController());
		mappings.put("/admin.do", new AdminController());
		mappings.put("/admin_R.do", new RecipController());
		mappings.put("/insert_R.do", new RecipeInsertController());
		mappings.put("/update_R.do", new RecipeUpdateController());
		mappings.put("/delete_R.do", new RecipeDeleteController());
		mappings.put("/admin_M.do", new MenuController());
		mappings.put("/insert_M.do", new MenuInsertController());
		mappings.put("/update_M.do", new MenuUpdateController());
		mappings.put("/delete_M.do", new MenuDeleteController());
		mappings.put("/adminView.do", new MenuRecipeController());
	}
	public Controller getController(String path) {
		return mappings.get(path);
	}
}
