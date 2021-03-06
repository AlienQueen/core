/*
 * Copyright (C) 2005 Iulian-Corneliu Costan
 * 
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 * 
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 * 
 * You should have received a copy of the GNU Lesser General Public License
 * along with this library; if not, write to the Free Software Foundation, Inc.,
 * 59 Temple Place, Suite 330, Boston, MA 02111-1307 USA
 */
package wicket.contrib.tinymce.settings;

import java.io.Serializable;

/**
 * @author Iulian-Corneliu COSTAN
 */
class Control implements Serializable
{
	private static final long serialVersionUID = 1L;
	private Button button;
	private TinyMCESettings.Toolbar toolbar;
	private TinyMCESettings.Position position;

	Control(Button button, TinyMCESettings.Toolbar toolbar, TinyMCESettings.Position position)
	{
		this.button = button;
		this.toolbar = toolbar;
		this.position = position;
	}

	/**
	 * @return the button for this control
	 */
	public Button getButton()
	{
		return button;
	}

	/**
	 * @return the toolbar
	 */
	public TinyMCESettings.Toolbar getToolbar()
	{
		return toolbar;
	}

	/**
	 * @return toolbar's position
	 */
	public TinyMCESettings.Position getPosition()
	{
		return position;
	}
}
