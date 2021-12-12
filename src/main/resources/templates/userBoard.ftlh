<#import "parts/common.ftlh" as c>

<@c.page>
<h1>${messages[1].user.username} board :</h1>
        <div class="card card-body mt-5">
        <form method="post" enctype="multipart/form-data">
            <div class="mb-3">
                <input type="text" name="text" class="form-control" placeholder="Enter text"/>
            </div>
            <input type="hidden" name="_csrf" value="${_csrf.token}" />
            <div class="fmb-3">
                <button type="submit" class="btn btn-success">Sent</button>
            </div>
        </form>
        </div>

    <div class="row row-cols-1 row-cols-md-2 g-4 mt-3">
    <#list messages as message>
    <div class="col">
    <div class="card border-success mb-3">
        <div class="m-2">
            <span>${message.text}</span>
        </div>
        <div class="card-footer">
            ${message.user.username},
            ${message.date?datetime}
        </div>
    </div>
    </div>
        <#else>
        <div class="pt-10">
            No message
        </div>
    </#list>
    </div>
</@c.page>
