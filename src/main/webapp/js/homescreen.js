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
            
      success:function(data)
      {
          
          
          var data1=jQuery.parseJSON(data);

          alert(data1);
          for(var i in data1)
          {
              alert(data1[i].name);
          }
          //alert("hiiiiiiiiiiiiiiwefwgfsfersfwiii");
        
      }
      
   
      
   });
    
    
});
    
    
    
    
    
