Imports System.IO

Public Class frmTest
    Dim sp As Point
    Dim tri As clsTri

    Private Sub frmTest_Load(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles MyBase.Load
        Dim vs As New List(Of clsVertex)
        vs.Add(New clsVertex(100, 100))
        vs.Add(New clsVertex(100, 200))
        vs.Add(New clsVertex(200, 200))
        tri = New clsTri(vs)
    End Sub

    Private Sub Button1_Click(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles Button1.Click
        Dim g As Graphics = picCanvas.CreateGraphics
        tri.Draw(g)
    End Sub

End Class
