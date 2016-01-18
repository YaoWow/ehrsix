$(function(){
        $("#empNum").blur(function(){
             var $parent = $(this).parent();
             $parent.find(".formtips").remove();
             if( this.value==""){
                var errorMsg = '不可为空！';
                $parent.append('<span class="formtips onError">'+errorMsg+'</span>');
             }else{
                var okMsg = '';
                $parent.append('<span class="formtips onSuccess">'+okMsg+'</span>');
             }
        }).keyup(function(){
           $(this).triggerHandler("blur");
        }).focus(function(){
             $(this).triggerHandler("blur");
        });
        
        $("#empName").blur(function(){
            var $parent = $(this).parent();
            $parent.find(".formtips").remove();
            if( this.value==""){
               var errorMsg = '不可为空！';
               $parent.append('<span class="formtips onError">'+errorMsg+'</span>');
            }else{
               var okMsg = '';
               $parent.append('<span class="formtips onSuccess">'+okMsg+'</span>');
            }
       }).keyup(function(){
          $(this).triggerHandler("blur");
       }).focus(function(){
            $(this).triggerHandler("blur");
       });
        
        $("#empFolk").blur(function(){
            var $parent = $(this).parent();
            $parent.find(".formtips").remove();
            if( this.value==""){
               var errorMsg = '不可为空！';
               $parent.append('<span class="formtips onError">'+errorMsg+'</span>');
            }else{
               var okMsg = '';
               $parent.append('<span class="formtips onSuccess">'+okMsg+'</span>');
            }
       }).keyup(function(){
          $(this).triggerHandler("blur");
       }).focus(function(){
            $(this).triggerHandler("blur");
       });
        
        $("#empId").blur(function(){
            var $parent = $(this).parent();
            $parent.find(".formtips").remove();
            if( this.value==""){
               var errorMsg = '不可为空！';
               $parent.append('<span class="formtips onError">'+errorMsg+'</span>');
            }else{
               var okMsg = '';
               $parent.append('<span class="formtips onSuccess">'+okMsg+'</span>');
            }
       }).keyup(function(){
          $(this).triggerHandler("blur");
       }).focus(function(){
            $(this).triggerHandler("blur");
       });
        
        $("#empPolity").blur(function(){
            var $parent = $(this).parent();
            $parent.find(".formtips").remove();
            if( this.value==""){
               var errorMsg = '不可为空！';
               $parent.append('<span class="formtips onError">'+errorMsg+'</span>');
            }else{
               var okMsg = '';
               $parent.append('<span class="formtips onSuccess">'+okMsg+'</span>');
            }
       }).keyup(function(){
          $(this).triggerHandler("blur");
       }).focus(function(){
            $(this).triggerHandler("blur");
       });
        
        $("#jobName").blur(function(){
            var $parent = $(this).parent();
            $parent.find(".formtips").remove();
            if( this.value==""){
               var errorMsg = '不可为空！';
               $parent.append('<span class="formtips onError">'+errorMsg+'</span>');
            }else{
               var okMsg = '';
               $parent.append('<span class="formtips onSuccess">'+okMsg+'</span>');
            }
       }).keyup(function(){
          $(this).triggerHandler("blur");
       }).focus(function(){
            $(this).triggerHandler("blur");
       });
        
        $("#deptName").blur(function(){
            var $parent = $(this).parent();
            $parent.find(".formtips").remove();
            if( this.value==""){
               var errorMsg = '不可为空！';
               $parent.append('<span class="formtips onError">'+errorMsg+'</span>');
            }else{
               var okMsg = '';
               $parent.append('<span class="formtips onSuccess">'+okMsg+'</span>');
            }
       }).keyup(function(){
          $(this).triggerHandler("blur");
       }).focus(function(){
            $(this).triggerHandler("blur");
       });
        
        
        $("#empBirthplace").blur(function(){
            var $parent = $(this).parent();
            $parent.find(".formtips").remove();
            if( this.value==""){
               var errorMsg = '不可为空！';
               $parent.append('<span class="formtips onError">'+errorMsg+'</span>');
            }else{
               var okMsg = '';
               $parent.append('<span class="formtips onSuccess">'+okMsg+'</span>');
            }
       }).keyup(function(){
          $(this).triggerHandler("blur");
       }).focus(function(){
            $(this).triggerHandler("blur");
       });
        
        $("#empNum").blur(function(){
            var $parent = $(this).parent();
            $parent.find(".formtips").remove();
            if( this.value==""){
               var errorMsg = '不可为空！';
               $parent.append('<span class="formtips onError">'+errorMsg+'</span>');
            }else{
               var okMsg = '';
               $parent.append('<span class="formtips onSuccess">'+okMsg+'</span>');
            }
       }).keyup(function(){
          $(this).triggerHandler("blur");
       }).focus(function(){
            $(this).triggerHandler("blur");
       });
        
        $("#empNum").blur(function(){
            var $parent = $(this).parent();
            $parent.find(".formtips").remove();
            if( this.value==""){
               var errorMsg = '不可为空！';
               $parent.append('<span class="formtips onError">'+errorMsg+'</span>');
            }else{
               var okMsg = '';
               $parent.append('<span class="formtips onSuccess">'+okMsg+'</span>');
            }
       }).keyup(function(){
          $(this).triggerHandler("blur");
       }).focus(function(){
            $(this).triggerHandler("blur");
       });
    
})