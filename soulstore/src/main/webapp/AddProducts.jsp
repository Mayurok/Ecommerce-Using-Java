<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>ADD PRODUCT</title>
    <%@include file="includes/header.jsp"%>
</head>
<body>
    <%@ include file="includes/NavBar.jsp"%>
    <div class="container">
        <div class="card mx-auto my-5" style="max-width: 600px;">
            <div class="card-header text-center">Add Products</div>
            <div class="card-body">
                <form action="nakona" method="get" enctype="multipart/form-data">
                    <div class="form-group">
                        <label for="name">Name</label>
                        <input type="text" class="form-control" id="name" name="nigaa" placeholder="Enter product name" required>
                    </div>

                    <div class="form-group">
                        <label for="category">Category</label>
                        <select class="form-control" id="cat" name="cat" required>
                            <option value="Childrens">Children's</option>
                            <option value="High Top Sneaker">High Top Sneaker</option>
                            <option value="Sneaker">Sneaker</option>
							<option value="Sliders">Mens Sliders</option>
    
                        </select>
                    </div>

                    <div class="form-group">
                        <label for="price">Price</label>
                        <input type="text" class="form-control" id="price" name="pri" placeholder="Enter product price" required>
                    </div>

                    <div class="form-group">
                        <label for="imageUpload">Image</label>
                        <input type="file" class="form-control-file" id="imageUpload" name="ima">
                    </div>

                    <div class="text-center">
                        <button type="submit" class="btn btn-primary">Add Product</button>
                    </div>
                </form>
            </div>
        </div>
    </div>

    <%@include file="includes/footer.jsp"%>
    
</body>
</html>
