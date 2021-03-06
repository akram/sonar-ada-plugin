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

package com.echosource.ada.core;

import org.apache.commons.lang.StringUtils;
import org.sonar.api.resources.Language;
import org.sonar.api.resources.Resource;
import org.sonar.api.utils.WildcardPattern;

import com.echosource.ada.Ada;

/**
 * Defines a php package
 */
@SuppressWarnings("rawtypes")
public class AdaDirectory extends Resource {

  /** The Constant DEFAULT_PACKAGE_NAME. */
  public static final String DEFAULT_PACKAGE_NAME = "(default)";

  /**
   * Instantiates a new php package.
   */
  public AdaDirectory() {
    this(null);
  }

  /**
   * Instantiates a new php package.
   * 
   * @param key
   *          the key
   */
  public AdaDirectory(String key) {
    setKey(StringUtils.defaultIfEmpty(StringUtils.trim(key), DEFAULT_PACKAGE_NAME));
  }

  /**
   * @see org.sonar.api.resources.Resource#getLongName()
   */
  @Override
  public String getLongName() {
    return getName();
  }

  /**
   * Checks if this package is the default one.
   * 
   * @return <code>true</code> the package key is empty, <code>false</code> in any other case
   */
  public boolean isDefault() {
    return StringUtils.equals(getKey(), DEFAULT_PACKAGE_NAME);
  }

  /**
   * Match file pattern.
   * 
   * @param antPattern
   *          the ant pattern
   * @return true, if match file pattern
   * @see org.sonar.api.resources.Resource#matchFilePattern(java.lang.String)
   */
  @Override
  public boolean matchFilePattern(String antPattern) {
    String patternWithoutFileSuffix = StringUtils.substringBeforeLast(antPattern, ".");
    WildcardPattern matcher = WildcardPattern.create(patternWithoutFileSuffix, ".");
    return matcher.match(getKey());
  }

  @Override
  public String getDescription() {
    return null;
  }

  @Override
  public Language getLanguage() {
    return Ada.INSTANCE;
  }

  @Override
  public String getName() {
    return getKey();
  }

  @Override
  public Resource<?> getParent() {
    return null;
  }

  @Override
  public String getQualifier() {
    return Resource.QUALIFIER_DIRECTORY;
  }

  @Override
  public String getScope() {
    return Resource.SCOPE_SPACE;
  }
}
