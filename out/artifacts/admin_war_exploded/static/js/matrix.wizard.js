
$(document).ready(function(){
	
	$("#form-wizard").formwizard({ 
		formPluginEnabled: true,
		validationEnabled: true,
		focusFirstInput : true,
		disableUIStyles : true,
	
		formOptions :{
			success: function(data){$("#status").fadeTo(500,1,function(){ $(this).html("<span>Form was submitted!</span>").fadeTo(5000, 0); })},
			beforeSubmit: function(data){$("#submitted").html("<span>Form was submitted with ajax. Data sent to the server: " + $.param(data) + "</span>");},
			dataType: 'json',
			resetForm: true
		},
		validationOptions : {
			rules: {
				username: "required",
				password: "required",
				password2: {
					equalTo: "#password"
				},
				email: { required: true, email: true },
				eula: "required"
			},
			messages: {
				username: "请输入用户名",
				password: "请输入密码",
				password2: { equalTo: "两次输入的密码不同" },
				email: { required: "请输入邮箱地址", email: "请输入正确的邮箱地址，例如name@domain.com" },
				eula: "请同意条款"
			},
			errorClass: "help-inline",
			errorElement: "span",
			highlight:function(element, errorClass, validClass) {
			$(element).parents('.control-group').addClass('error');
			},
			unhighlight: function(element, errorClass, validClass) {
				$(element).parents('.control-group').removeClass('error');
			}
		}
	});	
});
