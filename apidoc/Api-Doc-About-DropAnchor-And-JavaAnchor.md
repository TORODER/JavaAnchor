## Api-Doc-About-DropAnchor-And-JavaAnchor-V0.17_5

>Title String join "-V{{Version}}_{{Revise}}" build to Title	

---

​	

### Doc Info

​	Version: 0.17

>pre issue API doc so use Version is Negative ...

​	DateTime: 21/5/24

​	Revise: 5

> Revise Version  is Content revision does not add or delete interfaces



---

​	

### Index

[TOC]

---



### About Rule

​	Prefix: /api/{{Version}}/*

​	ResStructure:

```json
{
    "code":999,
    "data":{},
    "explain":""
}
```

​	

| Name    | Type   | Explain                              |
| ------- | ------ | ------------------------------------ |
| code    | int    | state code                           |
| data    | any    | about port res data struct           |
| explain | string | explain port info or state code info |

​	

---



### About Port



#### About Public Data Port Agg



##### GetServerPublicDataIndex

​	Name: 	Get Server Public Data Index Data

​	Explain: 	get server public lib data index

​	Href:	{{prefix}}/public/index



​	ReqType:	GET

​	ReqParameter:  NONE

​	ReqBody:	NONE



​	ResBody:	

```json
{
    "code": 2000
    "data": [
            {
                "name": "main",
                "type": "0",
                "child": [
                    {
                        "name": "DataComponent",
                        "type": "0",
                        "child": [
                            {
                                "name": "FsElem.java",
                                "type": "FILE",
                                "child": []
                            }
                        ]
                    },
                    {
                        "name": "Main.java",
                        "type": "1",
                        "child": []
                    },
                    {
                        "name": "ShowSrcDir.java",
                        "type": "1",
                        "child": []
                    },
                    {
                        "name": "resources",
                        "type": "0",
                        "child": []
                    }
                ]
            },
            {
                "name": "test",
                "type": "0",
                "child": [
                    {
                        "name": "java",
                        "type": "0",
                        "child": []
                    }
                ]
            }
        ],
    "explain": ""
}
```

About Res Struct explain 

###### FsElem - struct

> FsElem is below Struct Name 

| Name  | Type          | Explain                |
| ----- | ------------- | ---------------------- |
| name  | string        | Dir or File name       |
| type  | int           | DIR/1 \| FILE/0        |
| child | Array<FsElem> | child Dir or File Data |



---



##### GetServerPublicData

​	Name: 	Get In Server Dat	a  of Public Index  

​	Explain: 	get file content , use base64 encode

​	Href:	{{prefix}}/public/file



​	ReqType:	GET

​	ReqParameter:  ?path={{path}}

| Name | Type   | Explain                                   |
| ---- | ------ | ----------------------------------------- |
| path | string | ?path=/main/DataComponent/FsElem.java |

​	ReqBody:	NONE



IF Req Target is FILE

​	ResBody:	

```json
{
    "code": 2000,
    "data": "IyBHYW1lIExvb3AKClRoZSBHYW1lIExvb3AgbW9kdWxlIGlzIGEgc2ltcGxlIGFic3RyYWN0aW9uIG92ZXIgdGhlIGdhbWUgbG9vcCBjb25jZXB0LiBCYXNpY2FsbHkgbW9zdCBnYW1lcyBhcmUgYnVpbHQgdXBvbiB0d28gbWV0aG9kczoKCiogVGhlIHJlbmRlciBtZXRob2QgdGFrZXMgdGhlIGNhbnZhcyByZWFkeSBmb3IgZHJhd2luZyB0aGUgY3VycmVudCBzdGF0ZSBvZiB0aGUgZ2FtZS4KKiBUaGUgdXBkYXRlIG1ldGhvZCByZWNlaXZlcyB0aGUgZGVsdGEgdGltZSBpbiBzZWNvbmRzIHNpbmNlIGxhc3QgdXBkYXRlIGFuZCBhbGxvd3MgeW91IHRvIG1vdmUgdG8gdGhlIG5leHQgc3RhdGUuCgpUaGUgYEdhbWVgIGNsYXNzIGNhbiBiZSBleHRlbmRlZCBhbmQgd2lsbCBwcm92aWRlIHRoZXNlIGdhbWVsb29wIG1ldGhvZHMgYW5kIHRoZW4gaXRzIGluc3RhbmNlIEZsdXR0ZXIgd2lkZ2V0IHRyZWUgdmlhIHRoZSBgR2FtZVdpZGdldGAuCgpZb3UgY2FuIGFkZCBpdCBpbnRvIHRoZSB0b3Agb2YgeW91IHRyZWUgKGRpcmVjdGx5IGFzIGFuIGFyZ3VtZW50IHRvIGB",
    "explain": ""
}
```

About Res Struct explain 

| Name | Type   | Explain                                 |
| ---- | ------ | --------------------------------------- |
| data | string | file data content transform to base64 . |



IF Req Target is DIR

ResBody:	

```json
{
    "code": 4001,
    "data": "",
    "explain": ""
}
```

About Res Struct explain 

| Name | Type   | Explain              |
| ---- | ------ | -------------------- |
| data | string | is empty no out data |





---



##### PostUpdateServerPublicFile

​	Name: 	Post Update Server Public File

​	Explain: 	push file to server , but need use key

​	Href:	{{prefix}}/public/file



​	ReqType:	POST

​	ReqParameter:  ?path={{path}}

| Name | Type   | Explain                                   |
| ---- | ------ | ----------------------------------------- |
| path | string | ?path=/main/DataComponent/FsElem.java |

​	ReqBody:	

```json
{
    "key":"ASdas3di4oa5shgA09SDMN86V1OP",
    "date":"IyBHYW1lIExvb3AKClRoZSBHYW1lIExvb3AgbW9kdWxlIGlzIGEgc2ltcGxlIGFic3RyYWN0aW9uIG92ZXIgdGhlIGdhbWUgbG9vcCBjb25jZXB0LiBCYXNpY2FsbHkgbW9zdCBnYW1lcyBhcmUgYnVpbHQgdXBvbiB0d28gbWV0aG9kczoKCiogVGhlIHJlbmRlciBtZXRob2QgdGFrZXMgdGhlIGNhbnZhcyByZWFkeSBmb3IgZHJhd2luZyB0aGUgY3VycmVudCBzdGF0ZSBvZiB0aGUgZ2FtZS4KKiBUaGUgdXBkYXRlIG1ldGhvZCByZWNlaXZlcyB0aGUgZGVsdGEgdGltZSBpbiBzZWNvbmRzIHNpbmNlIGxhc3QgdXBkYXRlIGFuZCBhbGxvd3MgeW91IHRvIG1vdmUgdG8gdGhlIG5leHQgc3RhdGUuCgpUaGUgYEdhbWVgIGNsYXNzIGNhbiBiZSBleHRlbmRlZCBhbmQgd2lsbCBwcm92aWRlIHRoZXNlIGdhbWVsb29wIG1ldGhvZHMgYW5kIHRoZW4gaXRzIGluc3RhbmNlIEZsdXR0ZXIgd2lkZ2V0IHRyZWUgdmlhIHRoZSBgR2FtZVdpZGdldGAuCgpZb3UgY2FuIGFkZCBpdCBpbnRvIHRoZSB0b3Agb2YgeW91IHRyZWUgKGRpcmVjdGx5IGFzIGFuIGFyZ3VtZW50IHRvIGB"
}
```

About Res Struct explain 

| Name | Type   | Explain   |
| ---- | ------ | --------- |
| data | string | is base64 |





IF Req Target is FILE

​	ResBody:	

```json
{
    "code": 2000,
    "data": "",
    "explain": ""
}
```



IF Req Target is DIR

ResBody:	

```json
{
    "code": 4001,
    "data": "",
    "explain": ""
}
```

About Res Struct explain 

| Name | Type   | Explain                     |
| ---- | ------ | --------------------------- |
| data | string | is error path target is dir |



---



##### PostDelServerPublicFile

​	Name: 	Post Del Server Public File

​	Explain: 	del server target 

​	Href:	{{prefix}}/public/file



​	ReqType:	DELETE

​	ReqParameter:  ?path={{path}}

| Name | Type   | Explain                                   |
| ---- | ------ | ----------------------------------------- |
| path | string | ?path=/main/DataComponent/FsElem.java |

​	ReqBody: NONE	



IF Req Target is Success

​	ResBody:	

```json
{
    "code": 2000,
    "data": "",
    "explain": ""
}
```



IF Req Target Del Error

ResBody:	

```json
{
    "code": 4002,
    "data": "",
    "explain": ""
}
```

About Res Struct explain 

| Name    | Type   | Explain                     |
| ------- | ------ | --------------------------- |
| data    | string | is error path target is dir |
| explain | string | error info                  |









### About State Code



> 0~1999  is Retain State Code 
>
> > In the client side, the part that coincides with HTTP State Code can be used
>
> 2000~3999 Success Type State code
>
> 4000~5999 Failed Type State Code
>
> 6000~7999 Other steps are required State Code  ( undetermined )
>
> > Other steps are required State Code 
> >
> > example:
> >
> > Certification required 
> >
> > .... ( undetermined )

| State Code | Explain                                | Other |
| ---------- | -------------------------------------- | ----- |
| 2000       | Success                                |       |
| 4001       | Req target is Dir no is File So failed |       |
| 4002       | Del File Error                         |       |
|            |                                        |       |
|            |                                        |       |



