<#import "parts/common.ftlh" as c>

<@c.page>
<div class="my-3">
    <h3>User editor</h3>
</div>

<form action="/user" method="post">
    <input type="text" name="username" value="${user.username}">
    <#list roles as role>
        <div class="form-check my-2">
                <input type="checkbox" class="form-check-input" name="${role}" name="flexRadioDefault" id="flexRadioDefault1" ${user.roles?seq_contains(role)?string("checked", "")}>
                <label class="form-check-label" for="flexRadioDefault1">${role}</label>
        </div>
    </#list>

    <input type="hidden" name="userId" value="${user.id}">
    <input type="hidden" name="_csrf" value="${_csrf.token}" />
    <button type="submit" class="btn btn-primary">Save</button>
</form>
</@c.page>