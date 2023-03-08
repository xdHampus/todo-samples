from django.shortcuts import render
from django.http import HttpResponse
from django.views.generic import View


def getAll(request):
    return HttpResponse("Get all!")

class TodoIntParamView(View):
    def get(self, request, *args, **kwargs):
        return HttpResponse("Get get")

    def delete(self, request, *args, **kwargs):
        return HttpResponse("Deleted something??")

class TodoRequestBodyView(View):
    def get(self, request, *args, **kwargs):
        return getAll(request)
        
    def post(self, request, *args, **kwargs):
        return HttpResponse("Posted data??")

    def put(self, request, *args, **kwargs):
        return HttpResponse("Updated something??")
