package com.proxym.api.ManagedBean;

import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

import org.primefaces.validate.ClientValidator;

@FacesValidator("custom.edit.validator")
public class EditInputValidator  implements Validator, ClientValidator {

	@Override
	public Map<String, Object> getMetadata() {
		return null;
	}

	@Override
	public String getValidatorId() {
		return "custom.edit.validator";
	}
	@Override
	public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
//		TransferTypeResource entity = context.getApplication().evaluateExpressionGet(context, "#{transfer}", TransferTypeResource.class);
//		

			
		 FacesContext fc = FacesContext.getCurrentInstance(); 


		  // get password
		  UIInput uiInputMin = (UIInput) component.findComponent("min");
		  String min = uiInputMin.getSubmittedValue() == null ? ""
			: uiInputMin.getSubmittedValue().toString();
		  String minId = uiInputMin.getClientId();

		  // get confirm password
		  UIInput uiInputMax = (UIInput) component.findComponent("max");
		  
		  String max = uiInputMax.getSubmittedValue() == null ? ""
			: uiInputMax.getSubmittedValue().toString();

		  // Let required="true" do its job.
		  if (min.isEmpty() || max.isEmpty()) {
			  return;
		  }
		  Double dmin = Double.valueOf(min);
		  Double dmax = Double.valueOf(max);
			
			 if(dmin<=0   ){
				 uiInputMin.setValid(false);
				 throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Validation Error", 
	                     "Amount Must be positive"));
			 }
			 if(dmax <=0){
				 uiInputMax.setValid(false);
				 throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Validation Error", 
	                     "Amount Must be positive"));
			 }
		
				if( dmin>=dmax){
					//uiInputMin.setValid(false);
					 //uiInputMax.setValid(false);
					throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Validation Error", 
		                     "Max amount must be higher then Min amount"));
				}
 
//
//		  if (!min.equals(max)) {
//
//			FacesMessage msg = new FacesMessage("Password must match confirm password");
//			msg.setSeverity(FacesMessage.SEVERITY_ERROR);
//			fc.addMessage(minId, msg);
//			fc.renderResponse();
//
//		  }

		
		
	}

	
}
