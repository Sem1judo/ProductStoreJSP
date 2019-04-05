<%@ page import="beans.Product" %>
<%@ page import="dao.ProductDao" %>
<%@ page import="dao.AbstractDao" %>
<html>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
      integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<%Product product = new Product();%>
<%AbstractDao<Product> productDao = new ProductDao();%>
<body>
<div class="container">


    <table class="table">
        <thead class="thead-dark">
        <tr>
            <th scope="col">#</th>
            <th scope="col">Product</th>
            <th scope="col">Quantity</th>
            <th scope="col">Price</th>
            <th scope="col"></th>
        </tr>
        </thead>
        <tbody>
        <tr>
            <th scope="row">1</th>
            <td>somepr</td>
            <td>Otto</td>
            <td>@mdo</td>
            <td>
                <button type="button" class="btn btn-light">Edit</button>
                <button type="button" class="btn btn-dark">Save</button>
            </td>
        </tr>
        <tr>
            <th scope="row">2</th>
            <td>Jacob</td>
            <td>Thornton</td>
            <td>@fat</td>
            <td>
                <button type="button" class="btn btn-light">Edit</button>
                <button type="button" class="btn btn-dark">Save</button>
            </td>
        </tr>
        <tr>
            <th scope="row">3</th>
            <td>Larry</td>
            <td>the Bird</td>
            <td>@twitter</td>
            <td>
                <button type="button" class="btn btn-light">Edit</button>
                <button type="button" class="btn btn-dark">Save</button>
            </td>
        </tr>
        </tbody>
    </table>

    <table class="table">
        <thead class="thead-light">
        <tr>
            <th scope="col">#</th>
            <th scope="col">First</th>
            <th scope="col">Last</th>
            <th scope="col">Handle</th>
            <th scope="col"></th>
        </tr>
        </thead>
        <tbody>
        <tr>
            <th scope="row">1</th>
            <td></td>
            <td>
            </td>
            <td>@mdo</td>
            <td>
                <button type="button" class="btn btn-light">Edit</button>
                <button type="button" class="btn btn-dark">Save</button>
            </td>
        </tr>
        <tr>
            <th scope="row">2</th>
            <td>Jacob</td>
            <td>Thornton</td>
            <td>@fat</td>
            <td>
                <button type="button" class="btn btn-light">Edit</button>
                <button type="button" class="btn btn-dark">Save</button>
            </td>
        </tr>
        <tr>
            <th scope="row">3</th>
            <td>Larry</td>
            <td>the Bird</td>
            <td>@twitter</td>
            <td>
                <button type="button" class="btn btn-light">Edit</button>
                <button type="button" class="btn btn-dark">Save</button>
            </td>
        </tr>
        </tbody>
    </table>
                                <!-- Button for add my product -->

    <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#addProduct">
        Add product
    </button>
    <!-- Modal -->
    <div class="modal fade" id="addProduct" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
        <div class="modal-dialog modal-dialog-centered" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title">Add product</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">
                    <form action="/addProduct" method="post">
                        <div class="form-group col-6">
                            <label for="productName">Product name</label>
                            <input type="text" class="form-control" id="productName" placeholder="Your product" name="productName">
                        </div>
                        <div class="form-group col-6">
                            <label for="quantityProduct">Quantity</label>
                            <input type="number" class="form-control" id="quantityProduct" placeholder="Quantity products" name="quantityProduct">
                        </div>
                        <div class="form-group col-6">
                            <label for="Price">Price</label>
                            <input type="text" class="form-control" id="price" placeholder="Your price"  name="price">
                        </div>
                        <button type="submit" class="btn btn-danger">Submit</button>
                    </form>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                    <button type="button" class="btn btn-primary">Save changes</button>
                </div>
            </div>
        </div>
    </div>

</div>
</body>
</html>
