Imports System.IO
Imports System.Math

Public Class frmTest
    Dim Elems As clsElems
    Dim sp As Point
    Dim LeftMouseDown As Boolean

    Private Sub frmTest_Load(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles MyBase.Load
        Elems = New clsElems
        LeftMouseDown = False
        rbLine.Checked = True
    End Sub
    Private Sub picCanvas_MouseDown(ByVal sender As Object, ByVal e As System.Windows.Forms.MouseEventArgs) Handles picCanvas.MouseDown
        sp = e.Location
        LeftMouseDown = True
    End Sub

    Private Sub picCanvas_MouseMove(ByVal sender As Object, ByVal e As System.Windows.Forms.MouseEventArgs) Handles picCanvas.MouseMove
        If LeftMouseDown = False Then Return
        Dim g As Graphics = picCanvas.CreateGraphics
        Dim ep As Point = e.Location
        Dim elem As clsElem = Nothing
        elem = New clsLine(sp, ep)
        elem.Draw(g)
    End Sub

    Private Sub picCanvas_MouseUp(ByVal sender As Object, ByVal e As System.Windows.Forms.MouseEventArgs) Handles picCanvas.MouseUp
        LeftMouseDown = False
        Dim ep As Point = e.Location
        Dim elem As clsElem = Nothing
        If rbLine.Checked = True Then
            elem = New clsLine(sp, ep)
        End If
        If rbCircle.Checked = True Then
            Dim dx As Single = ep.X - sp.X, dy As Single = ep.Y - sp.Y
            Dim r As Single = Sqrt(dx * dx + dy * dy)
            elem = New clsCircle(sp, r)
        End If
        Elems.Append(elem)
        Draw()
    End Sub
    Sub Draw()
        Dim g As Graphics = picCanvas.CreateGraphics()
        Elems.Draw(g)
        Elems.Display(lstInfo)
    End Sub

End Class
