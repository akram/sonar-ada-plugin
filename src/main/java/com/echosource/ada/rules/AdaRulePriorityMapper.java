/*
 * Sonar, open source software quality management tool.
 * Copyright (C) 2010 SQLi
 * mailto:contact AT sonarsource DOT com
 *
 * Sonar is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 3 of the License, or (at your option) any later version.
 *
 * Sonar is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with Sonar; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02
 */

package com.echosource.ada.rules;

import org.sonar.api.rules.RulePriority;

/**
 * The Class AdaRulePriorityMapper.
 */
public class AdaRulePriorityMapper {

  /**
   * Returns a RulePriority instance from a given string
   * 
   * @param level
   *          the given value
   * 
   * @return the rule priority
   * 
   * @see org.sonar.api.rules.RulePriorityMapper#from(java.lang.Object) Major priority will be returned if given level is null
   */
  public static RulePriority from(String level) {
    if ("1".equals(level)) {
      return RulePriority.BLOCKER;
    }
    if ("2".equals(level)) {
      return RulePriority.CRITICAL;
    }
    if ("4".equals(level)) {
      return RulePriority.MINOR;
    }
    if ("5".equals(level)) {
      return RulePriority.INFO;
    }
    return RulePriority.MAJOR;
  }

  /**
   * Returns a string from a RulePriority instance.
   * 
   * @param priority
   *          the priority
   * 
   * @return the string
   * 
   * @see org.sonar.api.rules.RulePriorityMapper#to(org.sonar.api.rules.RulePriority)
   */
  public static String to(RulePriority priority) {
    if (RulePriority.BLOCKER.equals(priority)) {
      return "1";
    }
    if (RulePriority.CRITICAL.equals(priority)) {
      return "2";
    }
    if (RulePriority.MAJOR.equals(priority)) {
      return "3";
    }
    if (RulePriority.MINOR.equals(priority)) {
      return "4";
    }
    if (RulePriority.INFO.equals(priority)) {
      return "5";
    }
    throw new IllegalArgumentException("Level not supported: " + priority);
  }

}
