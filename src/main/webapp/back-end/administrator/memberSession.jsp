<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>memberSession</title>
</head>
<body>
<%@ include file="styles.jsp" %>


<!-- Main content -->
<div class="">
  <div class="container-fluid">
    <div class="row">
      <!-- left column -->
      <div class="col-md-12">
        <!-- general form elements -->
        <div class="card card-primary">
          <div class="card-header sym-darkpurple">
            <h3 class="card-title sym-yellow-font">搜尋列表</h3>
          </div>
          <!-- /.card-header -->

          <!-- form start -->
          <form id="memberSearch" METHOD="post" ACTION="<%=request.getContextPath()%>/back-end/administrator/adServlet">
            <div class="card-body">
              <div class="row">
                <div class="col-sm-12">
                  <div class="form-group">
                    <div class="row">
                      <div class="col-6">
                        <label class="sym-dark-font"
                          ><h5>會員查詢(編號:) : </h5></label
                        >
                        <input type="text" name="memberID">
                        <input type="hidden" name="action" value="getOne_For_Display" id="searchValue" />
                         <input type="submit" class="btn sym-darkpurple sym-yellow-font btn_style" value="送出">
                      </div>
                    </div>
                  </div>
                </div>
              </div>
            </div>
            <!-- /.card-body -->
            <div class="card-footer">
              <button
                type="submit"
                class="btn sym-darkpurple sym-yellow-font mb-2rem btn_style"
              >
                <i class="fa fa-search"></i>
               <a href='listAllMember.jsp' style="color: white;">所有會員</a>
              </button>
              <!-- <button
                id="resetTable"
                class="btn btn-default float-right"
              >
                重置
              </button> -->
            </div>
          </form>

          <div class="col-md-12">
            <div class="card card-primary">
              <div class="card-header sym-darkpurple">
                <h3 class="card-title sym-yellow-font">查詢結果</h3>
              </div>
              <!-- /.card-header -->
              <div class="card-body">
                <table
                  id="memberTable"
                  class="table table-bordered table-hover"
                >
                  <thead>
                    <tr>
                      <th>帳號</th>
                      <th>電子信箱</th>
                      <th>姓名</th>
                      <th>出生日期</th>
                      <th>手機號碼</th>
                      <th>居住地址</th>
                      <th>操作</th>
                    </tr>
                  </thead>
                  <tbody id="memberList">
                    <!-- javascript render memberlist -->
                  </tbody>
                </table>
              </div>
              <!-- /.card-body -->
            </div>
          </div>
          <!-- /.card-body -->
           <div class="card-footer mb-2rem">
<!--              <button -->
<!--                class="btn sym-darkpurple sym-yellow-font btn_style" -->
<!--                id="addProduct" -->
<!--              > -->
<!--                重置 -->
<!--              </button> -->
           </div>
         </div>
       </div>
     </div>
   </div>
 </div>
</div>
<!-- Main ends -->







</body>
</html>