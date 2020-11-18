Public Class clsTri
    Private Lines As List(Of clsLine) ' 约定3个
    Private vs As List(Of clsVertex)
    Public Sub New(ByVal vs As List(Of clsVertex))
        Me.vs = vs
        Lines = New List(Of clsLine)
        Lines.Add(New clsLine(vs(0), vs(1)))
        Lines.Add(New clsLine(vs(1), vs(2)))
        Lines.Add(New clsLine(vs(2), vs(0)))
    End Sub
    Public Sub Draw(ByVal g As Graphics)
        g.Clear(Color.Wheat)
        For i = 0 To Lines.Count - 1
            Lines(i).Draw(g)
        Next
    End Sub

    Sub [Select](ByVal p As Point)
        For i = 0 To vs.Count - 1
            vs(i).IsSelect(p)
        Next
    End Sub

    Sub Move(ByVal offset As Point)
        For i = 0 To vs.Count - 1
            vs(i).Move(offset)
        Next
    End Sub

End Class
