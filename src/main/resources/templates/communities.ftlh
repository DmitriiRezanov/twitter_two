<#import "parts/common.ftlh" as c>

<@c.page>

<h1>All communities :</h1>
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
