/*
 * Copyright (C) 2012 Alex Kuiper
 * 
 * This file is part of PageTurner
 *
 * PageTurner is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * PageTurner is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with PageTurner.  If not, see <http://www.gnu.org/licenses/>.*
 */
package net.nightwhistler.nucular.atom;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Represents a low-level Atom feed, as parsed from XML.
 * 
 * @author Alex Kuiper
 *
 */
public class Feed extends AtomElement {
	
	private List<Entry> entries = new ArrayList<Entry>();
	
	public List<Entry> getEntries() {
		return Collections.unmodifiableList( entries );
	}	
	
	public void addEntry(Entry entry) {
		this.entries.add(entry);
	}
	
	public Link getNextLink() {
		for ( Link link: getLinks() ) {
			if ( link.getRel().equals("next")) {
				return link;
			}
		}
		
		return null;
	}
	
	public Link getPreviousLink() {
		for ( Link link: getLinks() ) {
			if ( link.getRel().equals("previous")) {
				return link;
			}
		}
		
		return null;
	}
	
	public int getSize() {
		return getEntries().size();
	}
}
