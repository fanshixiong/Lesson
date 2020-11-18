Imports System.IO

Public Class frmTest
    Dim sp As Point
    Dim tri As clsTri

    Private Sub frmTest_Load(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles MyBase.Load
        Dim vs As New List(Of clsVertex)
        Dim v1 As New clsVertex(100, 100)
        AddHandler v1.ChangedSelected, AddressOf v_ChangedSelected
        AddHandler v1.Changed, AddressOf v_Changed
        vs.Add(v1)
        Dim v2 As New clsVertex(100, 200)
        AddHandler v2.ChangedSelected, AddressOf v_ChangedSelected
        AddHandler v2.Changed, AddressOf v_Changed
        vs.Add(v2)
        Dim v3 As New clsVertex(200, 200)
        AddHandler v3.ChangedSelected, AddressOf v_ChangedSelected
        AddHandler v3.Changed, AddressOf v_Changed
        vs.Add(v3)
        tri = New clsTri(vs)
    End Sub

    Private Sub v_ChangedSelected()
        Dim g As Graphics = picCanvas.CreateGraphics
        tri.Draw(g)
    End Sub
    Private Sub v_Changed()
        Dim g As Graphics = picCanvas.CreateGraphics
        tri.Draw(g)
    End Sub
    Private Sub Button1_Click(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles Button1.Click
        Dim g As Graphics = picCanvas.CreateGraphics
        tri.Draw(g)
    End Sub

    Private Sub picCanvas_MouseDown(ByVal sender As Object, ByVal e As System.Windows.Forms.MouseEventArgs) Handles picCanvas.MouseDown
        tri.Select(e.Location)
        sp = e.Location
    End Sub

    Private Sub picCanvas_MouseUp(ByVal sender As Object, ByVal e As System.Windows.Forms.MouseEventArgs) Handles picCanvas.MouseUp
        Dim ep As Point = e.Location
        Dim offset As New Point(ep.X - sp.X, ep.Y - sp.Y)
        tri.Move(offset)
    End Sub

    Private Sub picCanvas_Click(sender As Object, e As EventArgs) Handles picCanvas.Click

    End Sub

    Private Sub lstInfo_SelectedIndexChanged(sender As Object, e As EventArgs) Handles lstInfo.SelectedIndexChanged

    End Sub
End Class
