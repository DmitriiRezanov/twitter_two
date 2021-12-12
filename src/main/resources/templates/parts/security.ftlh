
<!-- Если объект определен в контексте, значит мы можем работать с сессией пользователя -->
<#assign
    known = Session.SPRING_SECURITY_CONTEXT??
>

<!-- Если объект определен в контексте, значит мы можем работать с сессией пользователя -->
<#if known>
    <#assign
        user = Session.SPRING_SECURITY_CONTEXT.authentication.principal
        name = user.getUsername()
        isAdmin = user.isAdmin()
    >
<!-- Если объект НЕ определен в контексте -->
<#else>
    <#assign
            name = "Please login"
            isAdmin = false
        >
</#if>