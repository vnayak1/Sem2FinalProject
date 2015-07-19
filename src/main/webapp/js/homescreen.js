/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

$(document).ready(function(){
    
    
    
     alert("hiiiisfwiii");
  
      $.ajax({
      url:"home",
      method: "get",
        dataType: 'text',
      success:function(data)
      {
          //alert("hiiiiiiiiiiiiiiwefwgfsfersfwiii");
          alert(data);
        $.each(data, function(index,value)
        {
           alert(value); 
        });
      }
      
   
      
   });
    
    
});
    
    
    
    
    
