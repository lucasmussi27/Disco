<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Gerencia Clientes</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.0/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</head>
<body>
    <div class="container">
        <div class="jumbotron">
            <h1>Artists</h1>
        </div>
    </div>
    <div class="row">
        <div class="col">
            <form action="/artists/new" method="POST">
                <div class="form-group">
                    <label for="name">NAME</label>
                    <input type="text" class="form-control" id="name" value="${(artist.name)!}">
                </div>
                <div class="form-group">
                    <label for="genre">GENRE</label>
                    <input type="text" class="form-control" id="genre" value="${(artist.genre)!}">
                </div>
                <button type="submit" class="btn btn-dark">NEW</button>
            </form>
        </div>
    </div>
    <div class="row">
        <div class="col">
            <table class="table table-striped table-hover">
                <thead class="thead-dark">
                    <tr>
                        <th>ID</th> <th>NAME</th> <th>GENRE</th> <th>OPTIONS</th>
                    </tr>
                </thead>
                <tbody>
                    <#list artists as artist>
                        <tr>
                            <td>${artist.id}</td>
                            <td>${artist.name}</td>
                            <td>${artist.genre}</td>
                            <td>
                                <a href="/artists/edit?id=${artist.id}">EDIT</a>
                                <a href="/artists/remove?id=${artist.id}">REMOVE</a>
                            </td>
                        </tr>
                    </#list>
                </tbody>
            </table>
        </div>
    </div>
</body>
</html>