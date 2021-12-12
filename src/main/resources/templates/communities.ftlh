<#import "parts/common.ftlh" as c>

<@c.page>

    <div class="row row-cols-1 row-cols-md-3 g-4">
        <#list communities as community>
            <div class="col">
                <h1>All communities</h1>
                <div class="card my-3">
                    <#if community.name??>
                        <a href="/community/${community.id}">${community.name}</a>
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
