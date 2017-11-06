<!--
   freemarker macros have to be imported into a namespace.
   We strongly recommend sticking to 'spring'
   -->
 
<#import "/spring.ftl" as spring/>
 
<html>
   <head>
      <title>Cancel direct debit confirmation</title>
   </head>
   <body>
         
      <div>
         <fieldset>
            <legend>Online Direct debit cancellation</legend>
            <div style="color:red;font-style:italic;">
Direct debit is cancelled with the  ${customer.customerName} ${customer.directDebitId} ${customer.directDebitType} 
        
      </div>
         </fieldset>
      </div> 
      
   </body>
   
</html>