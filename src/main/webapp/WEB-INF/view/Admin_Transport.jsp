<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!doctype html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<link rel="stylesheet" href="resources/css/bootstrap.min.css">
<link rel="stylesheet" href="resources/css/fontawesome-all.min.css">
<link rel="stylesheet" href="resources/css/datatables.min.css">
<link rel="stylesheet" href="resources/css/fullcalendar.min.css">
<link rel="stylesheet" href="resources/css/bootadmin.min.css">

<title>Transport | HiBookAdmin</title>
</head>
<body class="bg-light">

	<nav class="navbar navbar-expand navbar-dark bg-success">
		<a class="sidebar-toggle mr-3" href="#"><i class="fa fa-bars"></i></a>
		<a class="navbar-brand" href="#" style="font-weight: bold;">HiBook</a>

		<div class="navbar-collapse collapse">
			<ul class="navbar-nav ml-auto">
				
				<li class="nav-item dropdown"><a href="#" id="dd_user"
					class="nav-link dropdown-toggle" data-toggle="dropdown"><i
						class="fa fa-user"></i> ${pageContext.request.userPrincipal.name}</a>
					<div class="dropdown-menu dropdown-menu-right"
						aria-labelledby="dd_user">
						<a href="<%=request.getContextPath()%>/info_user/${getIdUseradmin}" class="dropdown-item">Profile</a> <a href="<%=request.getContextPath()%>/logout"
							class="dropdown-item">Logout</a>
					</div></li>
			</ul>
		</div>
	</nav>

	<div class="d-flex">
		<div class="sidebar sidebar-dark bg-dark">
			<ul class="list-unstyled">
				<li ><a href="adminmain"><i
						class="fa fa-fw fa-tachometer-alt"></i> Dashboard</a></li>
				<li><a href="#sm_base" data-toggle="collapse" aria-expanded="true"> <i
						class="fa fa-fw fa-cube"></i> Base </a>
					<ul id="sm_base" class="list-unstyled collapse show">
						<li ><a href="admin-author"> Tác giả</a></li>
						<li><a href="admin-status"> Tình trạng đơn hàng</a></li>
						<li><a href="admin-payment"> Thanh toán</a></li>
						<li><a href="admin-supplier"> Nhà cung cấp</a></li>
						<li class="active"><a href="admin-transport"> Vận chuyển</a></li>
						<li><a href="admin-typebook"> Loại sách</a></li>
						<li><a href="admin-userreview"> Review sách</a></li>
					</ul></li>
				<li><a href="admin-book"><i class="fas fa-fw fa-book"></i> Sách</a></li>
				<li><a href="admin-bill"><i class="fa fa-fw fa-edit"></i> Hóa đơn</a></li>
				<li><a href="admin-user"><i class="fa fa-fw fa-users"></i> Tài khoản</a></li>
				<li><a href="#"><i class="fas fa-gift"></i> Khuyến mãi</a></li>
			</ul>
		</div>
		<!-- CONTENT  -->
		<div class="content p-4">

			<h2 class="mb-4">Datatable Vận chuyển</h2>
			<div width="100%" style="text-align: right;">
				<a id="add-transport" href="#"
					class="btn btn-icon btn-pill btn-success" data-toggle="modal"
					data-target="#modalAdd"> <i class="fa fa-fw fa-plus"></i> Thêm
					vận chuyển
				</a>
			</div>

			<div class="card mb-4">
				<div class="card-body">
					<table id="table-transport"
						class="table table-hover dataTable no-footer dtr-inline"
						cellspacing="0" width="100%" role="grid"
						aria-describedby="example_info" style="width: 100%;">
						<thead>
							<tr>
								<th>ID</th>
								<th>Tên Vận chuyển</th>
								<th>Mô tả</th>
								<th>Chi phí</th>
								<th class="actions">Actions</th>
							</tr>
						</thead>
						<tbody id="list-transport">
							<!--  Add list transport -->
						</tbody>
					</table>
				</div>
			</div>
		</div>
		<!-- MODAL  ADD-->
		<div class="modal fade" id="modalAdd" tabindex="-1" role="dialog"
			aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
			<div class="modal-dialog modal-dialog-centered" role="document">
				<div class="modal-content">
					<div class="modal-header">
						<h5 class="modal-title" id="exampleModalCenterTitle">Thêm Vận
							chuyển</h5>
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
					</div>
					<!-- modal Body  -->
					<div class="modal-body">
						<div class="col-12">
							<label for="validationServer01">Tên loại Vận chuyển</label> <input
								type="text" class="form-control is-valid"
								id="validationServer01" placeholder="Name transport*" required>
							<div class="invalid-feedback" style="display: none;">Hãy
								nhập tên loại Vận chuyển.</div>
							<div class="valid-feedback" style="display: none;">Looks
								good!</div>
							<label for="validationServer02">Mô tả</label> <input type="text"
								class="form-control is-valid" id="validationServer02"
								placeholder="describes transport*" required> <label
								for="validationServer03">Phí dịch vụ</label> <input
								type="text" class="form-control is-valid"
								id="validationServer03" placeholder="fee transport*" required>

						</div>
					</div>
					<div class="modal-footer">
						<button id="close-add-transport" type="button"
							class="btn btn-secondary" data-dismiss="modal">Close</button>
						<button id="save-add-transport" class="btn btn-success">Save</button>
					</div>
				</div>
			</div>
		</div>
		<!-- MODAL  DELETE-->
		<div class="modal fade" id="modalDelete" tabindex="-1" role="dialog"
			aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
			<div class="modal-dialog modal-dialog-centered" role="document">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
					</div>
					<!-- modal Body  -->
					<div class="modal-body">
						<div class="col-12">
							<h5 id="xoa-title" class="modal-title">Bạn có chắc muốn xóa
								không?</h5>
						</div>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-danger" data-dismiss="modal">Cancel</button>
						<button id="delete-transport" class="btn btn-success">Delete</button>
					</div>
				</div>
			</div>
		</div>

	</div>

	<script src="resources/js/jquery.min.js"></script>
	<script src="resources/js/bootstrap.bundle.min.js"></script>
	<script src="resources/js/datatables.min.js"></script>
	<script src="resources/js/moment.min.js"></script>
	<script src="resources/js/fullcalendar.min.js"></script>
	<script src="resources/js/bootadmin.min.js"></script>
	<script src="resources/js/user-custom/Admin_Transport.js"></script>

	<script>
    window.dataLayer = window.dataLayer || [];
    function gtag(){dataLayer.push(arguments);}
    gtag('js', new Date());

    gtag('config', 'UA-118868344-1');
</script>

	<!-- CUSTOM JS AJAX  -->
	<!-- <script src="resources/js/user-custom/getListtransport.js"></script> -->

</body>
</html>