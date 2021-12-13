<#import "parts/common.ftlh" as c>

<@c.page>

<h1>All communities :</h1>

        <div class="card card-body mt-1">
        <form method="post">
            <div class="mb-3">
                <input type="text" name="name" class="form-control" placeholder="Create new community (Enter name community)"/>
            </div>
            <input type="hidden" name="_csrf" value="${_csrf.token}" />
            <div class="fmb-3">
                <button type="submit" class="btn btn-success">Create</button>
            </div>
        </form>
        </div>

    <div class="card text-center mt-5" style="width: 20rem;">

        <#list communities as community>
            <div class="col">

                <div class="card text-white bg-success mb-3 py-4 px-4">
                    <#if community.name??>
                        <a class="link-warning" href="/community/${community.id}">${community.name}</a>
                    </#if>
                </div>
            </div>
        <#else>
            <div class="pt-10">
                No message
            </div>
        </#list>
    </div>
</@c.page>
