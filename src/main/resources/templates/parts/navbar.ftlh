<#include "security.ftlh">
<#import "login.ftlh" as l>

<nav class="navbar navbar-expand-lg navbar-dark bg-success">
  <div class="container-fluid">
    <a class="navbar-brand" href="/">Twitter_two</a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <#assign
        known = Session.SPRING_SECURITY_CONTEXT??
    >
    <#if known>
        <#assign
            user2 = Session.SPRING_SECURITY_CONTEXT.authentication.principal
            id = user2.getId()
        >
    <!-- Если объект НЕ определен в контексте -->
    <#else>
        <#assign
        id = 1
        >
    </#if>

    <div class="collapse navbar-collapse" id="navbarSupportedContent">
      <ul class="navbar-nav me-auto mb-2 mb-lg-0">
        <li class="nav-item">
          <a class="nav-link active" aria-current="page" href="/userBoard/${id}">Home</a>
        </li>
        <li class="nav-item">
          <a class="nav-link active" aria-current="page" href="/community/">Communities</a>
        </li>
        <#if isAdmin>
        <li class="nav-item">
          <a class="nav-link active" aria-current="page" href="/user">User list</a>
        </li>
        </#if>
      </ul>
      <div class="navbar-text me-3">${name}</div>
      <#if name != "Please login">
        <@l.logout />
      </#if>
    </div>
  </div>
</nav>