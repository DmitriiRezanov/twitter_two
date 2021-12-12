<#import "parts/common.ftlh" as c>

<@c.page>
<div class="my-3">
    <h3>List of users</h3>
</div>


<div class="row row-cols-1 row-cols-md-3 g-4">
    <#list users as user>
        <div class="col">
            <div class="card my-3">
                    <div class="m-2">
                        <span>Username: ${user.username}</span>
                    </div>
                    <div class="m-2">
                        <span>Role: <#list user.roles as role>${role}<#sep>, </#list></span>
                    </div>
                    <div class="card-footer text-muted">
                        <a href="/user/${user.id}">Edit</a>
                    </div>
            </div>
        </div>
    <#else>
        <div class="pt-10">
                No user
        </div>
    </#list>
</div>



</@c.page>