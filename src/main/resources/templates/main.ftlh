<#import "parts/common.ftlh" as c>

<@c.page>

    <form method="get" action="main" class="frow row-cols-lg-auto g-1 align-items-center">
      <div class="form-group row mb-4">
             <div class="col-sm-6">
                 <input type="text" name="filter" class="form-control me-2" value="${filter?ifExists}" placeholder="Search by tag">
             </div>
             <div class="col-sm-6">
                 <button type="submit" class="btn btn-success">Search</button>
             </div>
      </div>
    </form>

    <a class="btn btn-success" data-bs-toggle="collapse" href="#collapseExample" role="button" aria-expanded="false" aria-controls="collapseExample">
    Add new message
    </a>

    <div class="collapse" id="collapseExample">
        <div class="card card-body">
        <form method="post" enctype="multipart/form-data">
            <div class="mb-3">
                <input type="text" name="text" class="form-control" placeholder="Enter text"/>
            </div>
            <div class="mb-3">
                <input type="text" name="tag" class="form-control" placeholder="Tag">
            </div>
            <div class="mb-3">
                <div class="input-group">
                    <input type="file" name="file" class="form-control" id="customFile">
                </div>
            </div>
            <input type="hidden" name="_csrf" value="${_csrf.token}" />
            <div class="fmb-3">
                <button type="submit" class="btn btn-success">Sent</button>
            </div>
        </form>
        </div>
    </div>

    <div class="row row-cols-1 row-cols-md-3 g-4">
    <#list messages as message>
    <div class="col">
    <div class="card my-3">
        <#if message.filename??>
            <img src="/img/${message.filename}" class="card-img-top">
        </#if>
        <div class="m-2">
            <span>${message.text}</span>
        </div>
        <div class="card-footer text-muted">
            <i>${message.tag}</i>,
            ${message.authorName}
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
