
<#macro login path isRegisterForm>
<form action="${path}" method="post">
     <div class="form-group row">
         <label for="inputLogin" class="col-sm-2 mb-2 col-form-label">Login :</label>
         <div class="col-sm-6">
            <input type="text" name="username" class="form-control" id="inputLogin" placeholder="Enter your login">
         </div>
     </div>
     <div class="form-group row">
         <label for="inputPassword" class="col-sm-2 mb-2 col-form-label">Password :</label>
         <div class="col-sm-6">
             <input type="password" name="password" class="form-control" id="inputPassword" placeholder="Enter password">
             <button type="submit" class="btn btn-primary me-3 mt-4"><#if isRegisterForm>Login!<#else>Sign in</#if></button>
                 <#if !isRegisterForm><a href="/registration" class="btn btn-secondary mt-4">Add new user</a></#if>
         </div>
     </div>

    <input type="hidden" name="_csrf" value="${_csrf.token}" />

</form>
</#macro>

<#macro logout>
<form action="/logout" method="post">
    <input type="hidden" name="_csrf" value="${_csrf.token}" />
    <button type="submit" class="btn btn-primary">Sign Out</button>
</form>
</#macro>