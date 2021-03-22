<%--
  Created by IntelliJ IDEA.
  User: moham
  Date: 3/22/2021
  Time: 5:53 PM
  To change this template use File | Settings | File Templates.
--%>


    <div class="border p-4 rounded mb-4">
        <div class="mb-4">
            <h3 class="mb-3 h6 text-uppercase text-black d-block">Filter by Price</h3>
            <br>
            <div style="margin-left: 20px;margin-right: 20px">
                <input type="text" id="slider" class="slider" />
            </div>

        </div>

        <div class="mb-4">
            <h3 class="mb-3 h6 text-uppercase text-black d-block">Size</h3>
            <c:forEach items="${applicationScope.Sizes}" var="Size">
                <label for="${Size}" class="d-flex">
                    <input name='Size' value="${Size}" type="checkbox" id="${Size}" class="mr-2 mt-1"> <span class="text-black">${Size}</span>
                </label>
            </c:forEach>

        </div>

        <div class="mb-4">
            <h3 class="mb-3 h6 text-uppercase text-black d-block">Color</h3>
            <c:forEach items="${applicationScope.Colors}" var="Color">
                <label for="${Color}" class="d-flex ">
                    <input name='Color'  value="${Color}" type="checkbox" id="${Color}" class="mr-2 mt-1">  <span class="text-black">${Color}</span>
                </label>
            </c:forEach>
        </div>
        <input class="btn btn-primary " type="submit" value="Submit">
    </div>



