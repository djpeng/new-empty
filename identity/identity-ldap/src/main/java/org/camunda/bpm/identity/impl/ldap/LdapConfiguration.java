/* Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.camunda.bpm.identity.impl.ldap;


import java.util.HashMap;
import java.util.Map;

import javax.naming.directory.SearchControls;

import org.camunda.bpm.engine.impl.digest.PasswordEncryptor;
import org.camunda.bpm.engine.impl.digest.ShaHashDigest;


/**
 * <p>Java Bean holding LDAP configuration</p>
 *
 * @author Daniel Meyer
 *
 */
public class LdapConfiguration {

  protected String initialContextFactory = "com.sun.jndi.ldap.LdapCtxFactory";
  protected String securityAuthentication = "simple";

  protected Map<String, String> contextProperties = new HashMap<String, String>();

  protected String serverUrl;
  protected String managerDn = "";
  protected String managerPassword = "";

  protected String baseDn = "";

  protected String userDnPattern = "";

  protected String userSearchBase = "";
  protected String userSearchFilter = "(objectclass=person)";

  protected String groupSearchBase = "";
  protected String groupSearchFilter = "(objectclass=groupOfNames)";

  protected String userIdAttribute = "uid";
  protected String userFirstnameAttribute = "cn";
  protected String userLastnameAttribute = "sn";
  protected String userEmailAttribute = "email";
  protected String userPasswordAttribute = "userpassword";

  protected String groupIdAttribute = "ou";
  protected String groupNameAttribute = "cn";
  protected String groupMemberAttribute = "memberOf";

  protected boolean sortControlSupported = false;

  protected boolean isUsePasswordDigest = false;

  protected PasswordEncryptor passwordEncryptor = new ShaHashDigest();


  // getters / setters //////////////////////////////////////

  public String getInitialContextFactory() {
    return initialContextFactory;
  }

  public void setInitialContextFactory(String initialContextFactory) {
    this.initialContextFactory = initialContextFactory;
  }

  public String getSecurityAuthentication() {
    return securityAuthentication;
  }

  public void setSecurityAuthentication(String securityAuthentication) {
    this.securityAuthentication = securityAuthentication;
  }

  public Map<String, String> getContextProperties() {
    return contextProperties;
  }

  public void setContextProperties(Map<String, String> contextProperties) {
    this.contextProperties = contextProperties;
  }

  public String getServerUrl() {
    return serverUrl;
  }

  public void setServerUrl(String serverUrl) {
    this.serverUrl = serverUrl;
  }

  public String getManagerDn() {
    return managerDn;
  }

  public void setManagerDn(String managerDn) {
    this.managerDn = managerDn;
  }

  public String getManagerPassword() {
    return managerPassword;
  }

  public void setManagerPassword(String managerPassword) {
    this.managerPassword = managerPassword;
  }

  public String getUserDnPattern() {
    return userDnPattern;
  }

  public void setUserDnPattern(String userDnPattern) {
    this.userDnPattern = userDnPattern;
  }

  public String getGroupSearchBase() {
    return groupSearchBase;
  }

  public void setGroupSearchBase(String groupSearchBase) {
    this.groupSearchBase = groupSearchBase;
  }

  public String getGroupSearchFilter() {
    return groupSearchFilter;
  }

  public void setGroupSearchFilter(String groupSearchFilter) {
    this.groupSearchFilter = groupSearchFilter;
  }

  public String getGroupNameAttribute() {
    return groupNameAttribute;
  }

  public void setGroupNameAttribute(String groupNameAttribute) {
    this.groupNameAttribute = groupNameAttribute;
  }


  public String getBaseDn() {
    return baseDn;
  }

  public void setBaseDn(String baseDn) {
    this.baseDn = baseDn;
  }

  public String getUserSearchBase() {
    return userSearchBase;
  }

  public void setUserSearchBase(String userSearchBase) {
    this.userSearchBase = userSearchBase;
  }

  public String getUserSearchFilter() {
    return userSearchFilter;
  }

  public void setUserSearchFilter(String userSearchFilter) {
    this.userSearchFilter = userSearchFilter;
  }

  public String getUserIdAttribute() {
    return userIdAttribute;
  }

  public void setUserIdAttribute(String userIdAttribute) {
    this.userIdAttribute = userIdAttribute;
  }

  public String getUserFirstnameAttribute() {
    return userFirstnameAttribute;
  }

  public void setUserFirstnameAttribute(String userFirstnameAttribute) {
    this.userFirstnameAttribute = userFirstnameAttribute;
  }

  public String getUserLastnameAttribute() {
    return userLastnameAttribute;
  }

  public void setUserLastnameAttribute(String userLastnameAttribute) {
    this.userLastnameAttribute = userLastnameAttribute;
  }

  public String getUserEmailAttribute() {
    return userEmailAttribute;
  }

  public void setUserEmailAttribute(String userEmailAttribute) {
    this.userEmailAttribute = userEmailAttribute;
  }

  public String getUserPasswordAttribute() {
    return userPasswordAttribute;
  }

  public void setUserPasswordAttribute(String userPasswordAttribute) {
    this.userPasswordAttribute = userPasswordAttribute;
  }

  public boolean isSortControlSupported() {
    return sortControlSupported;
  }

  public void setSortControlSupported(boolean sortControlSupported) {
    this.sortControlSupported = sortControlSupported;
  }

  public String getGroupIdAttribute() {
    return groupIdAttribute;
  }

  public void setGroupIdAttribute(String groupIdAttribute) {
    this.groupIdAttribute = groupIdAttribute;
  }

  public String getGroupMemberAttribute() {
    return groupMemberAttribute;
  }

  public void setGroupMemberAttribute(String groupMemberAttribute) {
    this.groupMemberAttribute = groupMemberAttribute;
  }

  public void setUsePasswordDigest(boolean isUsePasswordDigest) {
    this.isUsePasswordDigest = isUsePasswordDigest;
  }

  public boolean isUsePasswordDigest() {
    return isUsePasswordDigest;
  }

  /** The password encrptor to use for encrypting LDAP passwords.
   *
   * <p>Some LDAP systems are configured in a way that they do not store the actual user password but rather
   * some encrypted or hashed representation of the password. In order to authenticate against such LDAP
   * installations we need to use the same hash / encryption procedure for transforming the user-provided
   * password into the the encrypted / hashed form used by the LDAP installation.</p>
   *
   * <p>By default, password digesting is turned off. In order to turn it on, use
   * {@link #setUsePasswordDigest(boolean)}</p>
   *
   * <p>If turned on, the default password digest implementation is used which works with
   * base64 encoded SHA hashes.</p>
   *
   */
  public void setPasswordEncryptor(PasswordEncryptor passwordEncryptor) {
    this.passwordEncryptor = passwordEncryptor;
  }

  public PasswordEncryptor getPasswordEncryptor() {
    return passwordEncryptor;
  }

  public SearchControls getSearchControls() {
    SearchControls searchControls = new SearchControls();
    searchControls.setSearchScope(SearchControls.SUBTREE_SCOPE);
    searchControls.setTimeLimit(30000);
    return searchControls;
  }

}
