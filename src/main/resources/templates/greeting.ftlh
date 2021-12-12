<#include "parts/security.ftlh">
<#import "parts/common.ftlh" as c>


<@c.page>
<#if !known>
    <h5>Hello, anybody!</h5>
    <div>This is a simple clone of Twitter</div>
    <a href="/login">Login!</a>
<#else>
    <h5>Hello, ${name} </h5>
    <a href="/main">View messages</a>
</#if>


</@c.page>