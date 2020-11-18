Imports System.IO

Public Class frmTest
    Dim Lines As clsLines
    Dim sp As Point

    Private Sub frmTest_Load(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles MyBase.Load
        Lines = New clsLines
    End Sub
    Private Sub picCanvas_MouseDown(ByVal sender As Object, ByVal e As System.Windows.Forms.MouseEventArgs) Handles picCanvas.MouseDown
        sp = e.Location
    End Sub
    Private Sub picCanvas_MouseUp(ByVal sender As Object, ByVal e As System.Windows.Forms.MouseEventArgs) Handles picCanvas.MouseUp
        Dim ep As Point = e.Location
        Dim line As New clsLine(sp, ep)
        Lines.Append(line)
        Draw()
    End Sub
    Sub Draw()
        Dim g As Graphics = picCanvas.CreateGraphics()
        Lines.Draw(g)
        Lines.Display(lstInfo)
    End Sub

End Class
