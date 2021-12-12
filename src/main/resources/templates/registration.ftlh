<#import "parts/common.ftlh" as c>
<#import "parts/login.ftlh" as l>

<@c.page>
<div class="mt-5 mb-5">
    <h3>Add new user</h3>
</div>
${message?ifExists}
<@l.login "/registration" true />
</@c.page>
