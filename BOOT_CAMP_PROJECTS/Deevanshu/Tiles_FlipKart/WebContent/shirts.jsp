
   <%@ taglib uri="/struts-tags" prefix="s" %>

<s:form height="100" width="100">
<s:textfield name="username" label="Enter name"/>
<s:textfield name="contactnumber" label="Enter contact number"/>
<s:textfield name="quantity" label="Quantity" listKey="quantity" name="quantity"/>
<s:submit value="Add Items" action="order"/>

</s:form>

