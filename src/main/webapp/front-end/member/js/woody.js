$('input[type="radio"][name="custom_name"]').on("change", function () {
  //   console.log($(this).val());
  switch ($(this).val()) {
    case "1":
      $("#shop_input_text").show();
      //   console.log("1");
      break;
    case "2":
      $("#shop_input_text").hide();
      //   console.log("2");
      break;
  }
});

$(document).ready(function () {
  $("#shop_input_text").hide();
});

$("input#userPhoto").on("change", function (e) {
 // console.log("rrr");
  const file = this.files[0]; //將上傳檔案轉換為base64字串

  const fr = new FileReader(); //建立FileReader物件
  fr.onload = function (e) {
    $("img.user_img").attr("src", e.target.result); //读取的结果放入圖片
  };

  // 使用 readAsDataURL 將圖片轉成 Base64
  fr.readAsDataURL(file);
});



// 獲取輸入框的引用
let passwordInput = document.getElementById('password');
let retypeInput = document.getElementById('retype-password');
let oldpasswordInput = document.getElementById('oldpassword');//oldpassword

// 添加事件侦听器，在用戶點擊提交按鈕時檢查密碼是否一致
let form = document.getElementById('loginForm');
form.addEventListener('submit', function(event) {
  let password = passwordInput.value;
  let retype = retypeInput.value;
  let oldpassword = oldpasswordInput.value;
  
  if(oldpassword === ""){
	alert('請輸入舊密碼');
}
   

  // 檢查密碼是否一致
  if (password !== retype) {
    // 顯示錯誤消息
    alert('兩次輸入的密碼不一致，請重新輸入');

    // 阻止表單提交
    event.preventDefault();
  }
});
