<#import "/spring.ftl" as spring/>
 
<html>
   <head>
      <title>Cancel direct debit</title>
   </head>
   <body>
      <div>
         <fieldset>
            <legend>Online Direct debit cancellation</legend>
 			<#if errorMessage??>
      			<div style="color:red;font-style:italic;">
        			 ${errorMessage}
      			</div>
      		</#if>
            <form name="person" action="" method="POST">
				Customer Name: <@spring.formInput "customerForm.customerName" "" "text"/><br/>
				Customer debit Id: <@spring.formInput "customerForm.directDebitId" "" "text"/> <br/>
				Debit type: <@spring.formRadioButtons "customerForm.directDebitType", directDebitTypes,"" /><br/><br/>
				<input type="submit" value="Cancel" /> <br/>
            </form>
         </fieldset>
      </div>
      
      
   </body>
   
</html>