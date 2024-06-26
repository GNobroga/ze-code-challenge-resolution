# Ze Code Challange Resolution 


## Instalação

Para executar este projeto, primeiro é necessário ter o Docker instalado em sua máquina. Em seguida, você pode copiar e colar o comando abaixo em seu terminal para criar e executar o contêiner do MongoDB:

```bash
docker container run --name mongo --restart always -e MONGO_INITDB_ROOT_USERNAME=root -e MONGO_INITDB_ROOT_PASSWORD=root -e MONGO_INITDB_DATABASE=challangedb -p 27017:27017 -d mongo
```

Após executar o contêiner do MongoDB, siga estas etapas:

1. Clone o repositório do projeto:

```bash
    git clone https://github.com/GNobroga/ze-code-challenge-resolution.git
```

2. Navegue até a pasta clonada:

```bash
    cd ze-code-challenge-resolution
```

3. Execute o comando Gradle para iniciar a aplicação Spring Boot:

```bash
    ./gradlew bootRun
```

Este comando compila o projeto e inicia a aplicação Spring Boot. Certifique-se de ter o wrapper Gradle (arquivo gradlew) na raiz do projeto. 

Com esses passos, você estará executando sua aplicação Spring Boot após a inicialização do contêiner MongoDB.

O servidor será executado na porta `8080` do host da sua máquina.

## Populando banco 

Dentro da pasta src/main/resources, existe um arquivo chamado `application.properties`. Neste arquivo, há uma propriedade que, quando definida como `true`, permite carregar a aplicação com dados iniciais de um arquivo JSON contido no mesmo diretório.

```bash 
    data.loader.enable=true
```

## Descrição da Aplicação

A aplicação oferece as seguintes funcionalidades:

1. CRUD completo de parceiros: Permite criar, ler, atualizar e excluir informações de parceiros.
2. Busca por localização: Permite buscar parceiros com base em sua localização geográfica.

### Endpoints Disponíveis

A aplicação fornece os seguintes endpoints:

- `POST /partners`: Cria um novo parceiro.


Entrada:

```json
{
    "tradingName": "Lojinha do Biel",
    "ownerName": "Gabriel Cardoso",
    "document": "1432132123891/1111",
    "coverageArea": { 
        "type": "MultiPolygon", 
        "coordinates": [
        [[[30, 20], [45, 40], [10, 40], [30, 20]]], 
        [[[15, 5], [40, 10], [10, 20], [5, 10], [15, 5]]]
        ]
    },
    "address": { 
        "type": "Point",
        "coordinates": [30, 20]
    }
}
```

Saída:

```json
{
  "result": {
    "id": 54,
    "tradingName": "Lojinha do Biel",
    "ownerName": "Gabriel Cardoso",
    "document": "1432132123891/1111",
    "coverageArea": {
      "type": "MultiPolygon",
      "coordinates": [
        [
          [
            [30.0, 20.0],
            [45.0, 40.0],
            [10.0, 40.0],
            [30.0, 20.0]
          ]
        ],
        [
          [
            [15.0, 5.0],
            [40.0, 10.0],
            [10.0, 20.0],
            [5.0, 10.0],
            [15.0, 5.0]
          ]
        ]
      ]
    },
    "address": {
      "type": "Point",
      "coordinates": [30, 20]
    }
  }
}

```

- `GET /partners/{id}`: Retorna as informações de um parceiro específico com o ID fornecido.

- `PUT /partners/{id}`: Atualiza as informações de um parceiro existente com o ID fornecido.

- `DELETE /partners/{id}`: Exclui um parceiro existente com o ID fornecido.

- `GET /partners/search?lat={latitude}&long={longitude}`: Busca parceiros com base em uma determinada localização geográfica, representada pelas coordenadas de latitude e longitude fornecidas.

- `GET /partners?size=10&page=1&sort=-field1,field2`: Retorna uma lista paginada de parceiros, onde `size` define o número de registros por página, `page` especifica a página desejada e `sort` permite ordenar os resultados com base em um ou mais campos, sendo `-` para ordem descendente e nenhum prefixo para ascendente.

```json
{
  "page": 0,
  "size": 100,
  "totalElements": 1,
  "result": [
    {
      "id": 1,
      "tradingName": "Adega Osasco",
      "ownerName": "Ze da Ambev",
      "document": "02.453.716/000170",
      "coverageArea": {
        "type": "MultiPolygon",
        "coordinates": [
          [
            [
              [
                -43.36556,
                -22.99669
              ],
              [
                -43.36539,
                -23.01928
              ],
              [
                -43.26583,
                -23.01802
              ],
              [
                -43.25724,
                -23.00649
              ],
              [
                -43.23355,
                -23.00127
              ],
              [
                -43.2381,
                -22.99716
              ],
              [
                -43.23866,
                -22.99649
              ],
              [
                -43.24063,
                -22.99756
              ],
              [
                -43.24634,
                -22.99736
              ],
              [
                -43.24677,
                -22.99606
              ],
              [
                -43.24067,
                -22.99381
              ],
              [
                -43.24886,
                -22.99121
              ],
              [
                -43.25617,
                -22.99456
              ],
              [
                -43.25625,
                -22.99203
              ],
              [
                -43.25346,
                -22.99065
              ],
              [
                -43.29599,
                -22.98283
              ],
              [
                -43.3262,
                -22.96481
              ],
              [
                -43.33427,
                -22.96402
              ],
              [
                -43.33616,
                -22.96829
              ],
              [
                -43.342,
                -22.98157
              ],
              [
                -43.34817,
                -22.97967
              ],
              [
                -43.35142,
                -22.98062
              ],
              [
                -43.3573,
                -22.98084
              ],
              [
                -43.36522,
                -22.98032
              ],
              [
                -43.36696,
                -22.98422
              ],
              [
                -43.36717,
                -22.98855
              ],
              [
                -43.36636,
                -22.99351
              ],
              [
                -43.36556,
                -22.99669
              ]
            ]
          ]
        ]
      },
      "address": {
        "type": "Point",
        "coordinates": [
          -43.297337,
          -23.013538
        ]
      }
    }
]
```



Link para o repositório do desafio <a href="https://github.com/ab-inbev-ze-company/ze-code-challenges/blob/master/backend_pt.md">Clique aqui</a>


## Tecnologias

- Java 17
- Gradle
- Model Mapper
- MongoDB
- Docker 