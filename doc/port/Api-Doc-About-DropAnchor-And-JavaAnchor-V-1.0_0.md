## Api-Doc-About-DropAnchor-And-JavaAnchor-V-1.0_0

>Title String join "-V{{Version}}_{{Revise}}" build to Title

---



### Doc Info

​	Version: -1.0

>pre issue API doc so use Version is Negative ...

​	DateTime: 21/3/18          

 	Revise: 0

> Revise Version  is Content revision does not add or delete interfaces



---



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



---



### About Port

#### ####  Get File Port Agg



	##### GetServerPublicDataIndexData

​	Name: 	GetServerPublicDataIndexData

​	Explain: 	get server public lib data index

​	Href:	{{prefix}}/public/index



​	ReqType:	GET

​	ReqParameter:  NONE

​	ReqBody:	NONE



​	ResBody:	

```json
{
    "code": 2000
    "data": {
        "name": "src",
        "type": "DIR",
        "child": [
            {
                "name": "main",
                "type": "DIR",
                "child": [
                    {
                        "name": "DataComponent",
                        "type": "DIR",
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
                        "type": "FILE",
                        "child": []
                    },
                    {
                        "name": "ShowSrcDir.java",
                        "type": "FILE",
                        "child": []
                    },
                    {
                        "name": "resources",
                        "type": "DIR",
                        "child": []
                    }
                ]
            },
            {
                "name": "test",
                "type": "DIR",
                "child": [
                    {
                        "name": "java",
                        "type": "DIR",
                        "child": []
                    }
                ]
            }
        ]
    },
    "explain": ""
}
```

About Res Struct explain 

###### FsElem - struct

> FsElem is below Struct Name 

| Name  | Type          | Explain                |
| ----- | ------------- | ---------------------- |
| name  | string        | Dir or File name       |
| type  | string        | DIR \| FILE            |
| child | Array<FsElem> | child Dir or File Data |



---



	##### GetInServerDataofOpenIndex  

​	Name: 	Get In Server Data  of Public Index  

​	Explain: 	explain

​	Href:	{{prefix}}/public/



​	ReqType:	GET

​	ReqParameter:  ?path={{path}}

| Name | Type   | Explain                                   |
| ---- | ------ | ----------------------------------------- |
| path | string | ?path=/src/main/DataComponent/FsElem.java |

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





### About State Code



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
|            |                                        |       |
| 4001       | Req target is Dir no is File So failed |       |
|            |                                        |       |
|            |                                        |       |
|            |                                        |       |
|            |                                        |       |



