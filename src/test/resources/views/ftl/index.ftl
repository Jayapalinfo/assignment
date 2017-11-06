 
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
				
				<input type="submit" value="Cancel" /> <br/>
            </form>
         </fieldset>
      </div>
      
      
   </body>
   
</html>