package com.camunda.fox.platform.test.functional.ejb.remote.bean;

import javax.inject.Named;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;

import com.camunda.fox.platform.test.util.JndiConstants;

/**
 * A CDI bean delegating to the remote business 
 * interface of a SFSB from a different application.
 * 
 * @author Daniel Meyer
 *
 */
@Named
public class RemoteSFSBClientDelegateBean implements JavaDelegate {
  
  private BusinessInterface businessInterface = JndiConstants.lookup("java:global/" +
              JndiConstants.getAppName() +
              "service/" +
              "RemoteSFSBean!com.camunda.fox.platform.test.functional.ejb.remote.bean.BusinessInterface");

  @Override
  public void execute(DelegateExecution execution) throws Exception {
    execution.setVariable("result", businessInterface.doBusiness());
  }
  
}